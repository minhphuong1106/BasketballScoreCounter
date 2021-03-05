package com.example.basketballscorecounter;

public class BasketBallCounterBusiness {
    private int _Counter;
    private int _IncrementType1Id;
    private int _IncrementType2Id;
    private int _IncrementType3Id;
    private int _DisplayCtrlId;

    public int get_Counter() {return _Counter;}
    public int get_DisplayCtrlId() {return _DisplayCtrlId;}

    public BasketBallCounterBusiness(int incrementType1Id, int incrementType2Id, int incrementType3Id, int displayCtrlId ){
        this._Counter = 0;
        this._IncrementType1Id = incrementType1Id;
        this._IncrementType2Id = incrementType2Id;
        this._IncrementType3Id = incrementType3Id;
        this._DisplayCtrlId = displayCtrlId;
    }

    public void incrementCounter(int incrementTypeId) {
        if (incrementTypeId == this._IncrementType1Id) {
            this._Counter = this._Counter + 1;
            return;
        } else if (incrementTypeId == this._IncrementType2Id) {
            this._Counter = this._Counter + 2;
            return;
        } else if (incrementTypeId == this._IncrementType3Id) {
            this._Counter = this._Counter + 3;
            return;
        }
    }

    public void resetCounter(){
        this._Counter = 0;
    }
}
