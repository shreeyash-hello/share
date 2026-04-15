package com.uselessme.stillalive;

import java.io.Serializable;
import java.time.LocalDate;

public class SaleRecord implements Serializable{

	private static final long serialVersionUID = 1L;

	private static int count = 202600001;

    private int saleId;
    private String productName;
    private Category category;
    private LocalDate saleDate;
    private int quantity;
    private double amount;

    public SaleRecord(String productName, Category category,
                      int quantity, double amount) throws InvalidInputException, EmptyFieldException {
    	
        if (productName == null || productName.trim().isEmpty()) {
            throw new EmptyFieldException("Product name cannot be empty");
        }
    	
    	if(category == null) {
    		throw new InvalidInputException("Category must be selected");
    	}

	    if (quantity <= 0) {
	        throw new InvalidInputException("Quantity must be greater than 0");
	    }

	    if (amount <= 0) {
	        throw new InvalidInputException("Amount must be greater than 0");
	    }

        this.saleId = count++;
        this.productName = productName;
        this.category = category;
        this.saleDate = LocalDate.now();
        this.quantity = quantity;
        this.amount = amount;
    }

    public static void setCount(int value) {
        count = value;
    }

    public int getSaleId() {
		return saleId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
    public String toString() {
        return saleId + " | " + productName + " | " + category +
               " | " + saleDate + " | " + quantity + " | " + amount;
    }
}