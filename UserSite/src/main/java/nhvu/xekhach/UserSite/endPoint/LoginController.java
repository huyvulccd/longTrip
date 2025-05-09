package nhvu.xekhach.UserSite.endPoint;

import jakarta.validation.ConstraintViolationException;
import nhvu.xekhach.UserSite.component.annotations.ValidPhoneNumber;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@Validated
public class Login {
    @PostMapping("/login")
    public ResponseEntity<String> receivePhone(@RequestParam @ValidPhoneNumber String phoneNumber) {
        return ResponseEntity.ok("Login successful");
    }

    @PostMapping("/otp/login")
    public ResponseEntity<String> receiveOtp(@PathVariable String otp) {
        // Simulating OTP verification
        if (otp.equals("123456")) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid OTP");
        }
    }

    // Handle validation errors only for this controller
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidationException(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body("❌ Invalid phone number: " + ex.getMessage());
    }
}
