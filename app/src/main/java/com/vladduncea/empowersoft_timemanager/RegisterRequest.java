package com.vladduncea.empowersoft_timemanager;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vlad on 25-May-16.
 */
public class RegisterRequest extends StringRequest {

    private static final String Site_URL_Register = "http://vlad3199.5gbfree.com/Register.php";
    private Map<String,String> params;

    public RegisterRequest(String FirstName, String LastName, String Username, String Password, String Email, Response.Listener<String> listener){
        super(Method.POST,Site_URL_Register,listener,null);
        params = new HashMap<>();
        params.put("FirstName",FirstName);
        params.put("LastName", LastName);
        params.put("Username",Username);
        params.put("Password",Password);
        params.put("Email", Email);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
