package com.vladduncea.empowersoft_timemanager;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vlad on 25-May-16.
 */
public class LoginRequest extends StringRequest {

    private static final String Site_URL_Login = "http://vlad3199.5gbfree.com/Login.php";
    private Map<String,String> params;

    public LoginRequest(String Username, String Password,Response.Listener<String> listener){
        super(Method.POST,Site_URL_Login,listener,null);
        params = new HashMap<>();
        params.put("Username",Username);
        params.put("Password",Password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
