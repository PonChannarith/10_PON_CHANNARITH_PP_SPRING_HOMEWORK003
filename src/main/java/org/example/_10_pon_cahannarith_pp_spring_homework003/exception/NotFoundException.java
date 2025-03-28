package org.example._10_pon_cahannarith_pp_spring_homework003.exception;

public class NotFoundException extends RuntimeException{
        public NotFoundException(String message){
            super(message+ "Not found");
        }
}
