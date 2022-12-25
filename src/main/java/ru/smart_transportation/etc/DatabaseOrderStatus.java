package ru.smart_transportation.etc;

public enum DatabaseOrderStatus {
    PENDING(1),
    REJECTED(2),
    AWAITING_PAYMENT(3),
    AWAITING_DELIVERY(4),
    BEING_DELIVERED(5),
    ARRIVED(6),
    DELIVERED(7);

    private final int id;

    DatabaseOrderStatus(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
