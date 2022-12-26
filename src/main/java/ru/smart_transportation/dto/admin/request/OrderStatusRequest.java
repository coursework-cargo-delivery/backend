package ru.smart_transportation.dto.admin.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusRequest {
    private Integer orderId;
    private Integer newStatusId;
}
