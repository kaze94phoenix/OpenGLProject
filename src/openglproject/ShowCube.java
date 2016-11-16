/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package openglproject;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import org.lwjgl.opengl.Util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
/**
 *
 * @author Gaara-X
 */
public class ShowCube {
    private static ShowCube ShowCube;
    private int qtd = 1;
    private float rotacao1 = 0;
    
    private float rotacao2 = 20;
    private float rotX = 0.2f;
    private float rotY = 0.2f;
    private float rotZ = 0.2f;
    
    float cubo1Desl = -8.0f;
    float cubo1Desl1 = -8.0f;
    float cubo2Desl = 8.0f;
    float cubo2Desl2 = 8.0f;
    
    float cubo1Inc =  0.09f;
    float cubo2Inc =  0.09f;
    
    static boolean vai = true;
    static boolean vai2 = true;
    
    private boolean vFrente;
    private boolean vTraz;
    private boolean vCima;
    private boolean vBaixo;
    private boolean vEsq;
    private boolean vDir;
    
    private float[] frente = {0.3f, 0.75f, 1.5f};
    private float[] traz = {0.3f, 0.55f, 1.5f};
    private float[] cima = {0.7f, 0.75f, 1.5f};
    private float[] baixo = {0.3f, 0.75f, 1.5f};
    private float[] esq = {0.56f, 0.75f, 1.5f};
    private float[] dir = {0.3f, 1.75f, 1.5f};

    public ShowCube() {
       vFrente=false;
       vTraz=false;
       vCima=false;
       vBaixo=true;
       vEsq=true;
       vDir=true;
//       createDisplay();
//        loopOneCube();
//        cleanUp();
    }

    public ShowCube(boolean vFrente, boolean vTraz, boolean vCima, boolean vBaixo, boolean vEsq, boolean vDir, float[] frente, float[] traz, float[] cima, float[] baixo, float[] esq, float[] dir) {
        super();
        this.vFrente = vFrente;
        this.vTraz = vTraz;
        this.vCima = vCima;
        this.vBaixo = vBaixo;
        this.vEsq = vEsq;
        this.vDir = vDir;
        this.frente = frente;
        this.traz = traz;
        this.cima = cima;
        this.baixo = baixo;
        this.esq = esq;
        this.dir = dir;
        this.qtd=qtd;
//       createDisplay();
//        loopOneCube();
//        cleanUp();  
    }
    
    
    
    /*
    public MostrarCubo(boolean vFrente, boolean vTraz, boolean vCima, boolean vBaixo, boolean vEsq, boolean vDir, float[] frente, float[] traz, float[] cima, float[] baixo, float[] esq, float[] dir) {
        super();
    }
    */
    public float getRotacao() {
        return rotacao1;
    }

    

    public boolean isvFrente() {
        return vFrente;
    }

    public boolean isvTraz() {
        return vTraz;
    }

    public boolean isvCima() {
        return vCima;
    }

    public boolean isvBaixo() {
        return vBaixo;
    }

    public boolean isvEsq() {
        return vEsq;
    }

    public boolean isvDir() {
        return vDir;
    }

    public float[] getFrente() {
        return frente;
    }

    public float[] getTraz() {
        return traz;
    }

    public float[] getCima() {
        return cima;
    }

    public float[] getBaixo() {
        return baixo;
    }

    public float[] getEsq() {
        return esq;
    }

    public float[] getDir() {
        return dir;
    }

    
    float a = -1.5f;
 
    public void createDisplay(){
         try {
            // TODO code application logic here
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException ex) {
            Logger.getLogger(OpenGLProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loopOneCube(){
       Camera cam = new Camera(70,(float)Display.getWidth()/(float)Display.getHeight(),0.3f,1000);
        while(!Display.isCloseRequested()){
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glLoadIdentity();
        cam.useView();
        

     
            glPushMatrix();
        glTranslatef(0,0,-10);
        glRotatef(rotacao1, 2, 2, 0);

        glBegin(GL_QUADS);
        {
        getFrente(isvFrente(), getFrente());
        getTraz(isvTraz(), getTraz());
        getBaixo(isvBaixo(), getBaixo());
        getCima(isvCima(), getCima());
        getEsquerda(isvEsq(), getEsq());
        getDireita(isvDir(), getDir());
        }
        glEnd();
        glFlush();
        glPopMatrix();
        rotacao1 += 0.2f;  
        
        Display.update();
                    }
    }
    
    
    
    public void loopTwoCubes() {
        Camera cam = new Camera(70,(float)Display.getWidth()/(float)Display.getHeight(),0.3f,1000);
        while(!Display.isCloseRequested()){
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glLoadIdentity();
        cam.useView();
        
        
            glPushMatrix();
        glTranslatef(0,0,-10);
        glRotatef(rotacao1, 2, 2, 0);

        glBegin(GL_QUADS);
        {
        getFrente(isvFrente(), getFrente());
        getTraz(isvTraz(), getTraz());
        getBaixo(isvBaixo(), getBaixo());
        getCima(isvCima(), getCima());
        getEsquerda(isvEsq(), getEsq());
        getDireita(isvDir(), getDir());
        }
        glEnd();
        glFlush();
        glPopMatrix();
        
        glPushMatrix();
        glTranslatef(0,5,-10);
        glRotatef(rotacao1, 2, 2, 0);

        glBegin(GL_QUADS);
        {
        getFrente(isvFrente(), getFrente());
        getTraz(isvTraz(), getTraz());
        getBaixo(isvBaixo(), getBaixo());
        getCima(isvCima(), getCima());
        getEsquerda(isvEsq(), getEsq());
        getDireita(isvDir(), getDir());
        }
        glEnd();
        glFlush();
        glPopMatrix();
        rotacao1 += 0.2f;
        
       
        Display.update();
                    }
    }
    
    
    
    public void loopCubesColision(){
         Camera cam = new Camera(70,(float)Display.getWidth()/(float)Display.getHeight(),0.3f,1000);
        float x=0;
         while(!Display.isCloseRequested()){
         glClear(GL_COLOR_BUFFER_BIT);
        // glLoadIdentity();
         cam.useView();
         cubo1(cubo1Desl);
        cubo2(cubo2Desl);
        
        sentidoDoCubo1(vai);
        sentidoDoCubo2(vai2);
        
        if(cubo1Desl >= 9.0f){
            vai = false;
        }
        if(cubo2Desl <= -9.0f){
            vai2 = false;
        }
        if(cubo1Desl <= -9.0f){
            vai = true;
        }
        if(cubo2Desl >= 9.0f){
            vai2 = true;
        }
        //************************************
        if(cubo1Desl >= -0.8f){
            vai = false;
        }
        if(cubo2Desl <= 0.8f){
            vai2 = false;
        }
            
           Display.update(); 
            
        }
    }
    
    public void loopCoordinatesDraw(){
         Camera cam = new Camera(70,(float)Display.getWidth()/(float)Display.getHeight(),0.3f,1000);
        float x=0;
         while(!Display.isCloseRequested()){
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        cam.useView();
        glLoadIdentity();
        glTranslatef(-1.5f, 0.0f, -8.0f);
        glRotatef(rotacao2, rotX, rotY, rotZ);
        
        //**********************************
        
        eixoX();
        eixoY();
        eixoZ();
        
        
        
        //**********************************
        glFlush();
         Display.update(); 
        //rotacao += 0.2f;
         }
    }
    
    public void executeCoordinatesDraw(){
        createDisplay();
        loopCoordinatesDraw();
        cleanUp(); 
    }
    
    public void executeOneCube(){
        createDisplay();
        loopOneCube();
        cleanUp(); 
    }
    
    public void executeTwoCubes(){
        createDisplay();
        loopTwoCubes();
        cleanUp();
    }
    public void executeCubesColision(){
        createDisplay();
        loopCubesColision();
        cleanUp();
    }
    
public void cleanUp(){
        Display.destroy(); 
    }
    
public void cubo1(float deslocamento) {
        
        glLoadIdentity();                 
        glTranslatef(deslocamento, 0.0f, -15.0f);  

        glBegin(GL_QUADS);      
        getFrente(isvFrente(), getFrente());
        getTraz(isvTraz(), getTraz());
        getBaixo(isvBaixo(), getBaixo());
        getCima(isvCima(), getCima());
        getEsquerda(isvEsq(), getEsq());
        getDireita(isvDir(), getDir());
        
       glEnd();  
//        
        //cubo1Desl += cubo1Inc;   
    }
    
    public void sentidoDoCubo1(boolean cubo1){
        if(cubo1){
            cubo1Desl += cubo1Inc;
        }else{
            cubo1Desl -= cubo1Inc;
        }
    }
    
    public void sentidoDoCubo2(boolean cubo2){
        if(cubo2){
            cubo2Desl -= cubo2Inc;
        }else{
            cubo2Desl += cubo2Inc;
        }
    }
    
    public void cubo2(float deslocamento) {
        
        glLoadIdentity();                 
        glTranslatef(deslocamento, 0.0f, -15.0f);  

        glBegin(GL_QUADS);                
        
        getFrente(isvFrente(), getFrente());
        getTraz(isvTraz(), getTraz());
        getBaixo(isvBaixo(), getBaixo());
        getCima(isvCima(), getCima());
        getEsquerda(isvEsq(), getEsq());
        getDireita(isvDir(), getDir());
        

        glEnd();  
        
        //cubo2Desl -= cubo1Inc;
    }
    
    public void eixoX(){
        
        glColor3f(1.0f, 0.0f, 0.0f); // red x
        glBegin(GL_LINES);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(4.0f, 0.0f, 0.0f);
        glEnd();
        glFlush();
    }
    
    public void eixoY(){
        
        glColor3f(0.0f, 1.0f, 0.0f); // red x
        glBegin(GL_LINES);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(0.0f, 4.0f, 0.0f);
        glEnd();
        glFlush();
    }
    
    public void eixoZ(){
        
        glColor3f(0.0f, 0.0f, 1.0f); // red x
        glBegin(GL_LINES);
        glVertex3f(0.0f, 0.0f, 0.0f);
        glVertex3f(0.0f, 0.0f, 4.0f);
        glEnd();
        glFlush();
    }

    
    
   

    //done
    public void getFrente(boolean isVisible, float[] cor) {
        if (isVisible) {
            glColor3f(cor[0], cor[1], cor[2]);
            glVertex3f(-1, -1, 1);
            glVertex3f(1, -1, 1);
            glVertex3f(1, 1, 1);
            glVertex3f(-1, 1, 1);
        } else {
        }
    }
    
    
    //done
    public void getTraz(boolean isVisible, float[] cor) {
        if (isVisible) {
            glColor3f(cor[0], cor[1], cor[2]);
            glVertex3f(-1, -1, -1);
            glVertex3f(1, -1, -1);
            glVertex3f(1, 1, -1);
            glVertex3f(-1, 1, -1);
        } else {
        }
    }

    // done
    public void getCima(boolean isVisible, float[] cor) {
        if (isVisible) {
            glColor3f(cor[0], cor[1], cor[2]);
            glVertex3f(1, 1, 1);
            glVertex3f(1, 1, -1);
            glVertex3f(-1, 1, -1);
            glVertex3f(-1, 1, 1);
        } else {
        }


    }

    // 
    public void getBaixo(boolean isVisible, float[] cor) {
        if (isVisible) {
            glColor3f(cor[0], cor[1], cor[2]);
            glVertex3f(-1, -1, 1);
            glVertex3f(1, -1, 1);
            glVertex3f(1, -1, -1);
            glVertex3f(-1, -1, -1);
        } else {
        }


    }

    //done
    public void getEsquerda(boolean isVisible, float[] cor) {
        if (isVisible) {
            glColor3f(cor[0], cor[1], cor[2]);
            glVertex3f(-1, -1, -1);
            glVertex3f(-1, -1, 1);
            glVertex3f(-1, 1, 1);
            glVertex3f(-1, 1, -1);
        } else {
        }


    }

    //done
    public void getDireita(boolean isVisible, float[] cor) {
        if (isVisible) {
            glColor3f(cor[0], cor[1], cor[2]);
            glVertex3f(1, -1, 1);
            glVertex3f(1, -1, -1);
            glVertex3f(1, 1, -1);
            glVertex3f(1, 1, 1);
           
        } else {
        }


    }
    
    
    public static void main(String[] args) {
       new ShowCube();
       }
    

      

    private void registerKeyAction(int VK_NUMPAD4, AbstractAction abstractAction) {
    }
}
