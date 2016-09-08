package edu.orangecoastcollege.cs273.fjuarez6.tipcalculator;

/**
 * Created by frddy on 9/8/2016.
 */
public class RestaurantBill {

    private double mAmount;
    private double mTipPercent;
    private double mTipAmount;
    private double mTotalAmount;

    public RestaurantBill() {
        this.mAmount = 0.0;
        this.mTipPercent = 0.0;
        this.mTipAmount = 0.0;
        this.mTotalAmount = 0.0;
    }

    public RestaurantBill(double mAmount, double mTipPercent) {
        this.mAmount = mAmount;
        this.mTipPercent = mTipPercent;
        recalculateAmounts();
    }

    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
        recalculateAmounts();
    }

    public double getTipPercent() {
        return mTipPercent;
    }

    public double getTipAmount() {
        return mTipAmount;
    }

    public void setTipPercent(double mTipPercent) {
        this.mTipPercent = mTipPercent;
        recalculateAmounts();
    }

    public double getTotalAmount() {
        return mTotalAmount;
    }

    private void recalculateAmounts()
    {
        mTipAmount = mAmount * mTipPercent;
        mTotalAmount = mAmount + mTipAmount;
    }
}
