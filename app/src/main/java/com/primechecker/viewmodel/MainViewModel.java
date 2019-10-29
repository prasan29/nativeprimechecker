package com.primechecker.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Class for ViewModel for MainActivity.
 */
public class MainViewModel extends ViewModel {
    private static final String TAG = "MainActivity";

    // Static block to initialize the native libraries.
    static {
        System.loadLibrary("native-lib");
    }

    public final MutableLiveData<String> mInput = new MutableLiveData<>();
    public final MutableLiveData<String> mResult = new MutableLiveData<>();
    public final MutableLiveData<String> mButtonText = new MutableLiveData<>();
    private String mInputString;

    /**
     * Constructor to initialize the member variables.
     */
    public MainViewModel() {
        mInput.setValue("");
        mButtonText.setValue("Submit");
        mInputString = null;
    }

    /**
     * Method for observing the LiveData events.
     */
    public void observeData(LifecycleOwner lifecycleOwner) {
        mInput.observe(lifecycleOwner, s -> {
            if (s != null && !s.isEmpty()) {
                mInputString = s;
            } else {
                mInputString = null;
            }
        });
    }

    /**
     * Button click event handler for "Submit" button.
     */
    public void onSubmitClicked() {
        if (isInputEmpty()) {
            try {
                int input = Integer.parseInt(mInputString);
                boolean isPrime = checkPrime(input);
                if (isPrime) {
                    mResult.setValue("The given number is Prime.");
                } else {
                    mResult.setValue("The given number is not Prime.");
                }
            } catch (NumberFormatException e) {
                mResult.setValue("Invalid number.");
            }
        }
    }

    /**
     * Method to check if the input String is null or not.
     *
     * @return True, if not null, false, otherwise.
     */
    private boolean isInputEmpty() {
        return mInputString != null && !mInputString.isEmpty();
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native boolean checkPrime(int num);
}
