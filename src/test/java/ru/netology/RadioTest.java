package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldSetRadioChanel(){
        radio.setCurrentRadioStation(3);
        assertEquals(3,radio.getCurrentRadioStation());
        System.out.println("Radio station is #" + radio.getCurrentRadioStation() + " now");
    }

    @Test
    public void shouldntSetUnavailableStationNumber(){
        radio.setCurrentRadioStation(15);
        assertNotEquals(15,radio.getCurrentRadioStation());
        System.out.println("Radio station is #" + radio.getCurrentRadioStation() + " now");
    }

    @Test
    public void shouldntSetNegativeStationNumber(){
        radio.setCurrentRadioStation(-7);
        assertNotEquals(-7,radio.getCurrentRadioStation());
        System.out.println("Radio station is #" + radio.getCurrentRadioStation() + " now");
    }

    @Test
    public void shouldSwitchStationToBeginningAfterMax(){
        System.out.println("shouldSwitchStationToBeginningAfterMax()");
        for (int i = radio.getCurrentRadioStation(); i < (radio.getMaxRadioStation() + 3); i++){
            radio.nextRadioStation();
            System.out.println(radio.getCurrentRadioStation());
        }
    }

    @Test
    public void shouldSwitchStationToEndAfterMin(){
        System.out.println("shouldSwitchStationToEndAfterMin()");
        for (int i = radio.getCurrentRadioStation(); i > (radio.getMinRadioStation() - 3); i--){
            radio.previousRadioStation();
            System.out.println(radio.getCurrentRadioStation());
        }
    }

    @Test
    public void shouldIncreaseVolume(){
        int previousVolumeLevel = radio.getCurrentRadioVolume() + 1;
        radio.increaseVolume();
        assertEquals(previousVolumeLevel,radio.getCurrentRadioVolume());
        System.out.println("Volume level " + radio.getCurrentRadioVolume());
    }

    @Test
    public void shouldDecreaseVolume(){
        int previousVolumeLevel = radio.getCurrentRadioVolume() - 1;
        radio.decreaseVolume();
        assertEquals(previousVolumeLevel,radio.getCurrentRadioVolume());
        System.out.println("Volume level " + radio.getCurrentRadioVolume());
    }

    @Test
    public void shouldntSetVolumeHigherMax(){
        System.out.println("shouldntSetVolumeHigherMax()");
        for (int i = radio.getCurrentRadioVolume(); i < (radio.getMaxVolumeRadio() + 3); i++){
            radio.increaseVolume();
            System.out.println(radio.getCurrentRadioVolume());
        }
    }

    @Test
    public void shouldntSetVolumeLowerMin(){
        System.out.println("shouldntSetVolumeLowerMin()");
        for (int i = radio.getCurrentRadioVolume(); i > (radio.getMinVolumeRadio() - 3); i--){
            radio.decreaseVolume();
            System.out.println(radio.getCurrentRadioVolume());
        }
    }

}