package com.cognizant.tdd;

public class AlertManager {

    private final NotificationService notificationService;

    public AlertManager(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void triggerAlert() {
        notificationService.sendNotification("Alert Triggered");
    }
}