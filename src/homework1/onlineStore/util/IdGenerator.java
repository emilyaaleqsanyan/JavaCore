package homework1.onlineStore.util;

import java.util.UUID;

public class IdGenerator {
    public static String generateId() {
        return UUID
                .randomUUID()
                .toString()
                .split("-")[0];
    }
}
