package com.example.ChallengerApiRestFull.CRUD.Models;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Getter
public class UsersRequestCreatedSave {
        @NotNull(message = "Es necesario un nombre")
        @NotEmpty(message = "Es necesario un nombre")
        private String name;
        @Getter
        @NotNull(message = "Ingrese un email con el formato valido xxxxx@xxxx.yyy")
        @NotEmpty(message = "Ingrese un email con el formato valido xxxxx@xxxx.yyy")
        private String email;
        @Getter
        @NotNull(message = "Ingrese un email con el formato valido xxxxx@xxxx.yyy")
        @Size(min = 5, message = "Ingrese una password de minimo 5 caracteres")
        @Size(max = 25, message = "Ingrese una password de maximo 25 caracteres")
        @NotEmpty(message = "Ingrese un email con el formato valido xxxxx@xxxx.yyy")
        private String password;
        @Getter
        @NotNull(message = "Debes llenar cada uno de los items del objeto Phones")
        @NotEmpty(message = "Debes llenar cada uno de los items del objeto Phones")
        private List<PhoneModels> phones;
        @NotNull(message = "Ingrese 'true' o 'false' para dejar activo o inactivo el usuario")
        @NotEmpty(message = "Ingrese 'true' o 'false' para dejar activo o inactivo el usuario")
        private Boolean isActive;

        public void setName(String name) {
                this.name = name;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public void setPhones(List<PhoneModels> phones) {
                this.phones = phones;
        }

        public Boolean getIsActive() {
                return isActive;
        }

        public void setIsActive(Boolean active) {
                isActive = active;
        }
}
