/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package openglproject;
import org.lwjgl.opengl.Util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private float rotacao = 0;
    
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
       createDisplay();
        loop();
        cleanUp();
    }

    public ShowCube(boolean vFrente, boolean vTraz, boolean vCima, boolean vBaixo, boolean vEsq, boolean vDir, float[] frente, float[] traz, float[] cima, float[] baixo, float[] esq, float[] dir,int qtd) {
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
       createDisplay();
        loop();
        cleanUp();  
    }
    
    
    
    /*
    public MostrarCubo(boolean vFrente, boolean vTraz, boolean vCima, boolean vBaixo, boolean vEsq, boolean vDir, float[] frente, float[] traz, float[] cima, float[] baixo, float[] esq, float[] dir) {
        super();
    }
    */
    public float getRotacao() {
        return rotacao;
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
    
    public void loop() {
        Camera cam = new Camera(70,(float)Display.getWidth()/(float)Display.getHeight(),0.3f,1000);
        while(!Display.isCloseRequested()){
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glLoadIdentity();
        cam.useView();
        
        if(qtd==2){
            glPushMatrix();
        glTranslatef(0,0,-10);
        glRotatef(rotacao, 2, 2, 0);

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
        glRotatef(rotacao, 2, 2, 0);

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
        rotacao += 0.2f;
        } 
        if (qtd==1){
            glPushMatrix();
        glTranslatef(0,0,-10);
        glRotatef(rotacao, 2, 2, 0);

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
        rotacao += 0.2f;  
        }
        Display.update();
                    }
    }
    
    public void cleanUp(){
        Display.destroy();
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
    

    public void registerAllKeyActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
