//package Learn;
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import io.smallrye.mutiny.Uni;
//
//public class UniSerializer extends JsonSerializer<Uni<?>> {
//    @Override
//    public void serialize(Uni<?> uni, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
//        try {
//            Object result = uni.await().indefinitely(); // Wait for Uni completion and get the result
//            jsonGenerator.writeObject(result); // Serialize the result
//        } catch (Exception e) {
//            e.printStackTrace(); // Handle any errors
//        }
//    }
//}
