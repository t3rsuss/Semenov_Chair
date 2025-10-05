package com.example.semenov_chair.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.view.View;
import com.example.semenov_chair.model.MainActivityChairModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<MainActivityChairModel> chairLiveData = new MutableLiveData<>();

    public MainActivityViewModel() {
        chairLiveData.setValue(new MainActivityChairModel());
    }

    public MutableLiveData<MainActivityChairModel> getChairLiveData() {
        return chairLiveData;
    }

    public void onNextButtonClicked(View v) {
        MainActivityChairModel model = chairLiveData.getValue();

        if (model == null) return;

        if (isAnyFieldEmpty(model)) {
            model.setShouldShowError(true);
            model.setShouldNavigateToSecondView(false);
        } else {
            model.setShouldShowError(false);
            model.setShouldNavigateToSecondView(true);
        }
        chairLiveData.setValue(model);
    }

    private boolean isAnyFieldEmpty(MainActivityChairModel model) {
        return model.getMaterial() == null || model.getMaterial().isEmpty()
                || model.getColor() == null || model.getColor().isEmpty()
                || model.getHeight() == null || model.getHeight().isEmpty()
                || model.getPrice() == null || model.getPrice().isEmpty();
    }
}
