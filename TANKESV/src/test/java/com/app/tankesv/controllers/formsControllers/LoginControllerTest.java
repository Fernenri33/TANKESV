package com.app.tankesv.controllers.formsControllers;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.app.tankesv.model.Creacion_Perfil;
import com.app.tankesv.repo.CreacionPerfilRepo;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreacionPerfilRepo loginRepository;

    @Test
    public void testLoginExitoso() throws Exception {
        String email = "juan.perez@example.com";
        String password = "password123";

        Creacion_Perfil perfil = new Creacion_Perfil();
        perfil.setCorreo(email);
        perfil.setPassword(password);

        when(loginRepository.findByCorreo(email)).thenReturn(perfil);

        mockMvc.perform(post("/login")
                .param("email", email)
                .param("password", password))
                .andExpect(status().isOk())
                .andExpect(content().string("Inicio de sesión exitoso"));
    }

    @Test
    public void testLoginCredencialesIncorrectas() throws Exception {
        String email = "juan.perez@example.com";
        String password = "wrongPassword";

        Creacion_Perfil perfil = new Creacion_Perfil();
        perfil.setCorreo(email);
        perfil.setPassword("password123");

        when(loginRepository.findByCorreo(email)).thenReturn(perfil);

        mockMvc.perform(post("/login")
                .param("email", email)
                .param("password", password))
                .andExpect(status().isOk())
                .andExpect(content().string("Credenciales incorrectas"));
    }

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
