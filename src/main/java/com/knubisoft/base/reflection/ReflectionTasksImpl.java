package com.knubisoft.base.reflection;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.reflections.scanners.Scanners.SubTypes;

public class ReflectionTasksImpl implements ReflectionTasks {

    @Override
    public Object createNewInstanceForClass(Class<?> cls) {
        if (cls == null) {
            throw new NoSuchElementException();
        }
        Constructor con;
        Object ob;
        try {
            con = cls.getConstructor(String.class);
            ob = con.newInstance("");
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return ob;
    }

    @Override
    public <T> Class<? extends T> findImplementationForInterface(Class<T> cls) {
        if (cls == null) {
            throw new NoSuchElementException();
        }
        Reflections reflections = new Reflections("com.knubisoft.base.reflection.model");
        Set<Class<? extends T>> result = reflections.getSubTypesOf(cls);
        if (result.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (Class<? extends T> impl : result) {
            return impl;
        }
        return null;
    }

    @Override
    public Map<String, Object> findAllFieldsForClass(Class<?> cls) throws NoSuchFieldException {
        if (cls == null) {
            throw new NoSuchElementException();
        }
        Map<String, Object> result = new HashMap<>();
        Class clazz = cls.getSuperclass();
        if (clazz != null) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                result.put(f.getName(), clazz.getDeclaredField(f.getName()));
            }
        }
        return result;
    }


    @Override
    public int countPrivateMethodsInClass(Class<?> cls) {
        if (cls == null) {
            throw new NoSuchElementException();
        }
        int count = 0;
        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            int modifiers = m.getModifiers();
            if (Modifier.isPrivate(modifiers)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isMethodHasAnnotation(Method method, Class<?> annotationUnderMethod) {
        if (annotationUnderMethod == null) {
            throw new NoSuchElementException();
        }
        int annotation = method.getDeclaredAnnotations().length;
        if (annotation > 0) {
            return true;
        }
        return false;
    }

    @Override
    @SneakyThrows
    public Object evaluateMethodByName(Class<?> cls, String name) {
        if (cls == null || name == null) {
            throw new NoSuchElementException();
        }
        Object ob = cls.getConstructor().newInstance();
        Method m = cls.getDeclaredMethod(name);
        return m.invoke(ob);
    }

    @Override
    @SneakyThrows
    public Object evaluateMethodWithArgsByName(Object obj, String name, Object... args) {
        if (obj == null || name == null || args == null) {
            throw new IllegalArgumentException();
        }
        Class<?>[] classes = Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new);
        Method m = obj.getClass().getMethod(name, classes);
        return m.invoke(obj, args);
    }

    @Override
    @SneakyThrows
    public Object changePrivateFieldValue(Object instance, String name, Object newValue) {
        Field field = instance.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(instance, newValue);
        return field.get(instance);
    }
}
