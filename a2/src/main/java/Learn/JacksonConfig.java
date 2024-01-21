//package Learn;
//
//import Learn.UniSerializerFactory;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//import io.quarkus.jackson.ObjectMapperCustomizer;
//import io.smallrye.mutiny.Uni;
//import jakarta.inject.Singleton;
//
//;
//
//@Singleton
//public class JacksonConfig implements ObjectMapperCustomizer {
//    @Override
//    public void customize(com.fasterxml.jackson.databind.ObjectMapper mapper) {
//        SimpleModule module = new SimpleModule();
//        module.addSerializer(Uni.class, new UniSerializerFactory.UniSerializer());
//        mapper.registerModule(module);
//    }
//}
