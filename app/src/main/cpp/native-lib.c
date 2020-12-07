//
// Created by Andriansyah Putra on 07/12/2020.
//

#include <jni.h>
#include <stdlib.h>

JNIEXPORT jdouble JNICALL
Java_id_ac_ui_cs_mobileprogramming_andriansyah_helloworld_MainActivity_JniCelciusToFahrenheit(
        JNIEnv *env, jobject this, jdouble celcius) {
    jdouble fahrenheit = (celcius * 9 / 5) + 32;
    return fahrenheit;
}

JNIEXPORT jdouble JNICALL
Java_id_ac_ui_cs_mobileprogramming_andriansyah_helloworld_MainActivity_JniCelciusToReamur(
        JNIEnv *env, jobject this, jdouble celcius) {
    jdouble reamur = celcius * 4 / 5;
    return reamur;
}

JNIEXPORT jdouble JNICALL
Java_id_ac_ui_cs_mobileprogramming_andriansyah_helloworld_MainActivity_JniFahrenheitToCelcius(
        JNIEnv *env, jobject this, jdouble fahrenheit) {
    jdouble celcius = (fahrenheit - 32) * 5 / 9;
    return celcius;
}

JNIEXPORT jdouble JNICALL
Java_id_ac_ui_cs_mobileprogramming_andriansyah_helloworld_MainActivity_JniFahrenheitToReamur(
        JNIEnv *env, jobject this, jdouble fahrenheit) {
    jdouble reamur = (fahrenheit - 32) * 4 / 9;
    return reamur;
}

JNIEXPORT jdouble JNICALL
Java_id_ac_ui_cs_mobileprogramming_andriansyah_helloworld_MainActivity_JniReamurToCelcius(
        JNIEnv *env, jobject this, jdouble reamur) {
    jdouble celcius = reamur * 5 / 4;
    return celcius;
}

JNIEXPORT jdouble JNICALL
Java_id_ac_ui_cs_mobileprogramming_andriansyah_helloworld_MainActivity_JniReamurToFahrenheit(
        JNIEnv *env, jobject this, jdouble reamur) {
    jdouble fahrenheit = (reamur * 9 / 4) + 32;
    return fahrenheit;
}