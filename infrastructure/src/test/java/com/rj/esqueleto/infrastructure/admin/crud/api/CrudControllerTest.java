package com.rj.esqueleto.infrastructure.admin.crud.api;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.rj.esqueleto.application.admin.crud.dto.InsertUpdate_Crud_Model;
import com.rj.esqueleto.application.admin.crud.service.Crud_Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CrudControllerTest {

    @Mock
    private Crud_Service crudService;

    @InjectMocks
    private CrudController crudController;

    private String repositoryType;

    @BeforeEach
    void setUp() {
        repositoryType = "inMysqlAdapter_JPA";
    }

    @Test
    void testSuccessInsert_Crud_Entity() {
        InsertUpdate_Crud_Model dtoInput = new InsertUpdate_Crud_Model(null, "Test Name Ruddy", "TestJanpierts@Description");
        
        Map<String, Object> serviceResponse = new HashMap<>();
        serviceResponse.put("state", 1);
        serviceResponse.put("message", "Entidad creada con éxito");
        serviceResponse.put("id", 100);
        
        Mockito.when(crudService.save_Crud_Entity(Mockito.eq(repositoryType), Mockito.any(InsertUpdate_Crud_Model.class)))
               .thenReturn(serviceResponse);

        ResponseEntity<?> response = crudController.createEntity(repositoryType, dtoInput);

        @SuppressWarnings("unchecked")
        Map<String, Object> body = (Map<String, Object>) response.getBody();

        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(body);
        assertEquals(1, body.get("state"));
        assertEquals(100, body.get("id"));
    }

    @Test
    void testFailInsert_Crud_Entity() {
        InsertUpdate_Crud_Model inputModel = new InsertUpdate_Crud_Model(null, "Test", "test@example.com");

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("state", -1);
        errorResponse.put("message", "Error interno al procesar la entidad");

        Mockito.when(crudService.save_Crud_Entity(Mockito.eq(repositoryType), Mockito.any(InsertUpdate_Crud_Model.class)))
               .thenReturn(errorResponse);

        ResponseEntity<?> response = crudController.createEntity(repositoryType, inputModel);

        @SuppressWarnings("unchecked")
        Map<String, Object> body = (Map<String, Object>) response.getBody();

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(body);
        assertEquals(-1, body.get("state"));
        assertEquals("Error interno al procesar la entidad", body.get("message"));
    }
}