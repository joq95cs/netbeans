
package castellanos.joqsan.javahttp;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class CRUD {
    
    public static void insertar(String json) throws Exception {
        
        HttpRequest solicitud  = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost/curso_php/java/java_http/insertar.php"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        
        HttpClient cliente = HttpClient.newHttpClient();
        
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + respuesta.statusCode());
        System.out.println("Response body: " + respuesta.body());
        
        JSONObject estatus = new JSONObject(respuesta.body());
        
        if(estatus.getString("estatus").equals("Correcto")) {
            
            JOptionPane.showMessageDialog(null, "Registro insertado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            
            JOptionPane.showMessageDialog(null, estatus.getString("error"), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        Marco.m.limpiar();
    }
    
    public static void buscar(String id) throws Exception {
        
        HttpRequest solicitud  = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost/curso_php/java/java_http/buscar.php"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(id))
                .build();
        
        HttpClient cliente = HttpClient.newHttpClient();
        
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + respuesta.statusCode());
        System.out.println("Response body: " + respuesta.body());
        
        JSONObject json = new JSONObject(respuesta.body());
        
        Marco.m.getTxtNombre().setText(json.getString("nombre"));
        Marco.m.getTxtEdad().setText("" + json.getInt("edad"));
        Marco.m.getTxtCiudad().setText(json.getString("ciudad"));
        Marco.m.getTxtEmpleo().setText(json.getString("empleo"));
    }
    
    public static void eliminar(String id) throws Exception {
        
        HttpRequest solicitud  = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost/curso_php/java/java_http/eliminar.php"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(id))
                .build();
        
        HttpClient cliente = HttpClient.newHttpClient();
        
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + respuesta.statusCode());
        System.out.println("Response body: " + respuesta.body());
        
        JSONObject estatus = new JSONObject(respuesta.body());
        
        if(estatus.getString("estatus").equals("Correcto")) {
            
            JOptionPane.showMessageDialog(null, "Registro insertado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            
            JOptionPane.showMessageDialog(null, estatus.getString("error"), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        Marco.m.limpiar();
    }
    
    public static void actualizar(String id) throws Exception {
        
        HttpRequest solicitud  = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost/curso_php/java/java_http/actualizar.php"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(id))
                .build();
        
        HttpClient cliente = HttpClient.newHttpClient();
        
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: " + respuesta.statusCode());
        System.out.println("Response body: " + respuesta.body());
        
        JSONObject estatus = new JSONObject(respuesta.body());
        
        if(estatus.getString("estatus").equals("Correcto")) {
            
            JOptionPane.showMessageDialog(null, "Registro insertado", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            
            JOptionPane.showMessageDialog(null, estatus.getString("error"), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        Marco.m.limpiar();
    }
}
