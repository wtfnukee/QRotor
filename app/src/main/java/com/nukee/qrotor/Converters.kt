package com.nukee.qrotor

fun getWifiCode(ssid: String, auth_type: String, password: String, hidden: Boolean): String {
    return "WIFI:S:$ssid;T:$auth_type;P:$password;H:$hidden;"
    // WIFI:S:<SSID>;T:<WPA|WEP|>;P:<password>;H:<hidden>;
}

fun getTelephoneCode(number: String): String {
    return "tel:$number"
}


