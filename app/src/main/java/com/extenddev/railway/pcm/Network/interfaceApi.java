package com.extenddev.railway.pcm.Network;

import com.extenddev.railway.pcm.Data.AgentData.Data;
import com.extenddev.railway.pcm.Data.Satitions.NodeData;
import com.extenddev.railway.pcm.Encryption.CustomsEnc;

import retrofit2.Call;
import retrofit2.http.GET;

public interface interfaceApi {
    //http://locationme.com/
    // tawasol/PCM/SYNCLOOKUP.ashx?action=SYNC_LOOKUPS_NORMAL&node=AGENTS


    //http://locationme.com/tawasol/PCM/SYNCLOOKUP.ashx?action=SYNC_LOOKUPS_ENC&node=AGENTS
//    @GET("tawasol/PCM/SYNCLOOKUP.ashx?action=SYNC_LOOKUPS_ENC&node=AGENTS")
//    Call<EncryptedCode>getEncyptedData();

    @GET("tawasol/PCM/SYNCLOOKUP.ashx?action=SYNC_LOOKUPS_ENC&node=AGENTS")
    Call<CustomsEnc>getAllDataDecrepted();

    @GET("tawasol/PCM/SYNCLOOKUP.ashx?action=SYNC_LOOKUPS_NORMAL&node=AGENTS")
    Call<Data> getAllAgent();




    //locationme.com/tawasol/PCM/SYNCLOOKUP.ashx?action=SYNC_LOOKUPS_NORMAL&node=LOCS
    @GET("tawasol/PCM/SYNCLOOKUP.ashx?action=SYNC_LOOKUPS_NORMAL&node=LOCS")
    Call< NodeData >getAllNodes();




}
