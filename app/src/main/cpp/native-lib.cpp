#include <jni.h>
#include <string>
#include "PrimeChecker.h"

/**
 * Method to check if the number is prime or not.
 */
extern "C" JNIEXPORT jboolean  JNICALL
Java_com_primechecker_viewmodel_MainViewModel_checkPrime(JNIEnv *env, jobject, jint num) {
    PrimeChecker primeChecker(num);

    return static_cast<jboolean> (primeChecker.checkPrime());
}