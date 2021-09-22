package com.example.demo.viewmodels;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerPageViewModel {
    private int currentIndex;
    private int nPages;
    private long count;
    private LocalDateTime generatedAt;
    private List<CustomerViewModel> customers;

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public int getnPages() {
        return nPages;
    }

    public void setnPages(int nPages) {
        this.nPages = nPages;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }

    public List<CustomerViewModel> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerViewModel> customers) {
        this.customers = customers;
    }
}
