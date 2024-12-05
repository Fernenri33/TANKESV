package com.app.tankesv.controllers.formsControllers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.app.tankesv.repo.UsuarioRepo;


@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioRepo loginRepository;

   

    @Test
    public void testLoginUsuarioNoEncontrado() throws Exception {
        String email = "noexiste@example.com";
        String password = "password123";

        when(loginRepository.findByCorreo(email)).thenReturn(null);

        mockMvc.perform(post("/login")
                .param("email", email)
                .param("password", password))
                .andExpect(status().isOk())
                .andExpect(content().string("Credenciales incorrectas"));
    }
}
