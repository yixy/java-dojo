package me.youzhilane.dojo;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class App
{
    public static void agentmain(String agentArgs, Instrumentation inst){
        ClassFileTransformer classFileTransformer = new DefineTransformer();
        System.out.println("agentArgs : " + agentArgs);
        inst.addTransformer(classFileTransformer);
    }

    static class DefineTransformer implements ClassFileTransformer{

        public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer)  {
            System.out.println("agentmain load Class:" + className);
            return classfileBuffer;
        }
    }

}
