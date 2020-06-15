package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldCreateRadioObjectWithAllArguments(){
        Radio radio = new Radio(0,6,1,0,10,3);
        assertEquals(0, radio.getMinRadioStation());
        assertEquals(6, radio.getMaxRadioStation());
        assertEquals(1, radio.getCurrentRadioStation());
        assertEquals(0, radio.getMinVolumeRadio());
        assertEquals(10, radio.getMaxVolumeRadio());
        assertEquals(3, radio.getCurrentRadioVolume());
    }

    @Test
    public void shouldSetMaxRadioChanel(){
        Radio radio = new Radio(12);
        assertEquals(12,radio.getMaxRadioStation());
    }

    @Test
    public void shouldSetRadioChanel(){
        radio.setCurrentRadioStation(3);
        assertEquals(3,radio.getCurrentRadioStation());
    }

    @Test
    public void shouldntSetUnavailableStationNumber(){
        radio.setCurrentRadioStation(15);
        assertNotEquals(15,radio.getCurrentRadioStation());
    }

    @Test
    public void shouldntSetNegativeStationNumber(){
        radio.setCurrentRadioStation(-7);
        assertNotEquals(-7,radio.getCurrentRadioStation());
    }

    @Test
    public void shouldSwitchStationToBeginningAfterMax(){
//      Начнет ли с 0 после достижения максимальной радиостанции
        radio.setCurrentRadioStation(8);
        radio.nextRadioStation();
        radio.nextRadioStation();
        radio.nextRadioStation();
        radio.nextRadioStation();
        assertEquals(2, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldSwitchStationToEndAfterMin(){
//      Начнет ли с последней станции после достижения первой
        radio.setCurrentRadioStation(1);
        radio.previousRadioStation();
        radio.previousRadioStation();
        radio.previousRadioStation();
        assertEquals(8, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldIncreaseVolume(){
        int nextVolumeLevel = radio.getCurrentRadioVolume() + 1;
        radio.increaseVolume();
        assertEquals(nextVolumeLevel,radio.getCurrentRadioVolume());
    }

    @Test
    public void shouldDecreaseVolume(){
        int previousVolumeLevel = radio.getCurrentRadioVolume() - 1;
        radio.decreaseVolume();
        assertEquals(previousVolumeLevel,radio.getCurrentRadioVolume());
    }

    @Test
    public void shouldntSetVolumeHigherMax(){
//      Не должен поднять громкость выше максимальной
        radio.setCurrentRadioVolume(9);
        radio.increaseVolume();
        radio.increaseVolume();
        radio.increaseVolume();
        assertEquals(10, radio.getCurrentRadioVolume());
    }

    @Test
    public void shouldntSetVolumeLowerMin(){
//      Не должен опустить громкость ниже минимальной
        radio.setCurrentRadioVolume(2);
        radio.decreaseVolume();
        radio.decreaseVolume();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentRadioVolume());
    }

    @Test
    public void shouldSetCurrentRadioVolume(){
        radio.setCurrentRadioVolume(7);
        assertEquals(7,radio.getCurrentRadioVolume());
    }

}