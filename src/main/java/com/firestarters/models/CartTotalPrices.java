package com.firestarters.models;

import org.decimal4j.util.DoubleRounder;

import java.text.DecimalFormat;

public class CartTotalPrices {
    double subtotal;
    double tax;
    double grandTotal;

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setCalcTax() {
        double tax=0.0825*this.subtotal;
        double drounder= DoubleRounder.round(tax,2);
        this.tax=drounder;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}
