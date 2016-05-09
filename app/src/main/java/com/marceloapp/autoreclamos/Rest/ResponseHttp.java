package com.marceloapp.autoreclamos.Rest;

import java.util.Map;

/**
 * Created by Marcelo on 8/5/2016.
 */
public class ResponseHttp {
    // the request url
    String response;

    // the requester ip
    String origin;

    // all headers that have been sent
    Map headers;

    // url arguments
    Map args;

    // post form parameters
    Map form;

    // post body json
    Map json;
}
