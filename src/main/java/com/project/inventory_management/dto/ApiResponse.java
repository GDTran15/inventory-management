package com.project.inventory_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ApiResponse <T>{
    private String status;
    private T data;
    private String message;

    public static <T> ApiResponse<T> error(String message){
        ApiResponse<T> apiResponse= new ApiResponse<>();
        apiResponse.status = "error";
        apiResponse.data = null;
        apiResponse.message = message;
        return apiResponse;
    }

    public  static <T> ApiResponse<T> success(T object){
        ApiResponse<T> apiResponse= new ApiResponse<>();
        apiResponse.status = "success";
        apiResponse.data = object;
        apiResponse.message = null;
        return apiResponse;
    }

}
