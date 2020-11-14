package com.example.middleware.springlearn.resource;

import com.example.middleware.springlearn.resource.util.ResourceUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.PathMatcher;

import java.io.IOException;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 自定义 {@link ResourcePatternResolver}
 * @see ResourcePatternResolver
 * @see org.springframework.core.io.support.PathMatchingResourcePatternResolver
 * @see java.nio.file.PathMatcher
 * @Description TODO
 * @Date: 2020/5/7 20:19
 * @Create by external_ll@163.com
 **/
public class CustomizedResourcePatternResolverDemo {

    public static void main(String[] args) throws IOException {

        String currentPath = "/" + System.getProperty("user.dir")+"/middleware-demo/spring-learn-demo/resource/src/main/java/com/example/middleware/springlearn/resource/";

        String locationPattern = currentPath+"*.java";

        PathMatchingResourcePatternResolver resolver  = new PathMatchingResourcePatternResolver(new FileSystemResourceLoader());

        resolver.setPathMatcher(new JavaFilePathMatch());
        Resource[] resources  = resolver.getResources(locationPattern);

        Stream.of(resources).map(ResourceUtils::getContent).forEach(System.out::println);

    }

    static class  JavaFilePathMatch implements PathMatcher {

        @Override
        public boolean isPattern(String path) {
            return path.endsWith(".java");
        }

        @Override
        public boolean match(String pattern, String path) {
            return path.endsWith(".java");
        }

        @Override
        public boolean matchStart(String pattern, String path) {
            return false;
        }

        @Override
        public String extractPathWithinPattern(String pattern, String path) {
            return null;
        }

        @Override
        public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
            return null;
        }

        @Override
        public Comparator<String> getPatternComparator(String path) {
            return null;
        }

        @Override
        public String combine(String pattern1, String pattern2) {
            return null;
        }
    }
}
