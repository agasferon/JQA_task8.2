package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Radio {
    private int minRadioStation = 0;
    private int maxRadioStation = 9;
    private int currentRadioStation = 3;
    private int minVolumeRadio = 0;
    private int maxVolumeRadio = 10;
    private int currentRadioVolume = 5;

    public Radio(int maxRadioStation) {
        this.maxRadioStation = maxRadioStation;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        if (currentRadioStation < minRadioStation){
            return;
        }
        if (currentRadioStation > maxRadioStation){
            return;
        }
        this.currentRadioStation = currentRadioStation;
    }

    public void nextRadioStation(){
        if ((currentRadioStation + 1) <= maxRadioStation){
            this.currentRadioStation = currentRadioStation + 1;
        } else
            this.currentRadioStation = minRadioStation;
    }

    public void previousRadioStation(){
        if ((currentRadioStation - 1) >= minRadioStation){
            this.currentRadioStation = currentRadioStation - 1;
        } else
            this.currentRadioStation = maxRadioStation;
    }

    public void increaseVolume(){
        if (currentRadioVolume < maxVolumeRadio){
            this.currentRadioVolume = currentRadioVolume + 1;
        }
        return;
    }

    public void decreaseVolume(){
        if (currentRadioVolume > minVolumeRadio){
            this.currentRadioVolume = currentRadioVolume - 1;
        }
        return;
    }

}