//
// Created by Prasanna on 29/10/19.
//

#include "PrimeChecker.h"

/**
 * Constructor for PrimeChecker class.
 *
 * @param num Number for which the prime ceck is performed.
 */
PrimeChecker::PrimeChecker(int num) {
    PrimeChecker::number = num;
}

/**
 * Method to check if the number is prime or not.
 *
 * @return True, if the given number is prime.
 */
bool PrimeChecker::checkPrime() {
    bool isPrime = true;

    for (int i = 2; i <= number / 2; i++) {
        if (number % i == 0) {
            return false;
        } else {
            isPrime = true;
        }
    }

    return isPrime;
}