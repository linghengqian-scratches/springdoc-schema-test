package com.lingh;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@SpringBootApplication
public class SpringdocSchemaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdocSchemaTestApplication.class, args);
    }

}

@RestController
class testController {
    @PatchMapping("/test")
    public String test(@RequestBody TestBO testBO) {
        return "test" + testBO.getPCount() + testBO.getCCount();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "TestBO")
class TestBO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Schema(description = "the id")
    private Integer id;
    @Schema(description = "something with c")
    private Integer cCount;
    @Schema(description = "something with p")
    private Integer pCount;
    @Schema(description = "test filed with something")
    private Integer testFiled;
}