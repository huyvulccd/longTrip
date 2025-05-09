package nhvu.xekhach.UserSite.component.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nhvu.xekhach.UserSite.component.enums.NotificationType;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationMessage {
    private NotificationType type;
    private String recipient;
    private String content;
}
