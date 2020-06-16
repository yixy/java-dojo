package me.youzhilane.dojo;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * Hello world!
 *
 */
public class App
{
    public static void premain(String agentArgs, Instrumentation inst){
        ClassFileTransformer classFileTransformer = new DefineTransformer();
        System.out.println("agentArgs : " + agentArgs);
        inst.addTransformer(classFileTransformer);
    }

    static class DefineTransformer implements ClassFileTransformer{

        @Override
        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            System.out.println("premain load Class:" + className);
            return classfileBuffer;
        }
    }

}
