package ru.smart_transportation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewProfile implements Serializable {
    private String companyName;
    private String phoneNumber;
}
