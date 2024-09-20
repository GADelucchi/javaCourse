package edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.controllers;

// Imports
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.models.Client;
import edu.coderhouse.FacturacionEntregaProyectoFinalDelucchi.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "ClientController")

public class ClientController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Getting all clients",
            description = "Allows to get all clients in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "404", description = "Successful operation. No content",
                    content = {@Content(schema = @Schema(example = "No clients in database"))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getClients() {
        try {
            List<Client> clients = clientService.getClients();
            if (clients.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No clients in database");
            } else {
                return ResponseEntity.ok(clients);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error during getting clients");
        }
    }

    @Operation(summary = "Creating new client",
            description = "Allows to create a new client in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request (any value is missing)",
                    content = {@Content(schema = @Schema(example = "Must insert a last name"))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveClient(@Valid @RequestBody Client client, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError().getDefaultMessage());
        }
        try {
            Client savedClient = clientService.createClient(client);
            return ResponseEntity.created(URI.create("/api/clients/" + savedClient.getIdClient())).body(savedClient);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error during creating client");
        }
    }

    @Operation(summary = "Getting a specific client",
            description = "Allows to get an specific client by ID in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class))}),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = {@Content(schema = @Schema(example = "Client not found"))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(value = "/client/{idClient}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getClientById(@PathVariable(name = "idClient") Integer idClient) {
        try {
            Optional<Client> client = clientService.findClientById(idClient);
            if (client.isPresent()) {
                return ResponseEntity.ok(client);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error during getting client");
        }
    }

    @Operation(summary = "Deleting a client",
            description = "Allows to delete a client by ID in the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted",
                    content = {@Content(schema = @Schema(example = "Client deleted"))}),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = {@Content(schema = @Schema(example = "Client not found"))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping(value = "/client/{idClient}")
    public ResponseEntity<?> deleteClient(@PathVariable(name = "idClient") Integer idClient) {
        try {
            clientService.deleteClientById(idClient);
            return ResponseEntity.ok("Client deleted");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error during deleting client");
        }
    }
}
