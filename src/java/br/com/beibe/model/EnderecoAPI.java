/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;import org.json.JSONArray;
import org.json.JSONObject;

;

/**
 *
 * @author Iury
 */
public class EnderecoAPI {
    
    private static HttpURLConnection conexao;   
    public static void main(String[]args){
        
            try {
                //CONEXÃO COM API CEP MÉTODO 1
                //cep = request.getParameter("CEP");
                BufferedReader leitor;
                String linha;
                StringBuffer conteudo = new StringBuffer();
                URL url = new URL("http://viacep.com.br/ws/${cep}/json/");
                conexao = (HttpURLConnection) url.openConnection();
                conexao.setRequestMethod("GET");
                conexao.setConnectTimeout(5000);
                conexao.setReadTimeout(5000);
                int status = conexao.getResponseCode();
               // Status da resposta System.out.println(status);
                if (status > 299){
                    leitor = new BufferedReader(new InputStreamReader(conexao.getErrorStream()));
                    while((linha = leitor.readLine())!=null){
                        conteudo.append(linha);
                    }
                    leitor.close();
                }else{
                    leitor = new BufferedReader (new InputStreamReader(conexao.getInputStream()));
                    while((linha = leitor.readLine())!=null){
                        conteudo.append(linha);                                           
                    }
                    leitor.close();
                }                    
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            } finally{
                conexao.disconnect();
            }
    }
    public static String parse(String conteudoBody){
           
           JSONObject album = new JSONObject(conteudoBody);
           String  cep = album.getString("cep");
           String rua = album.getString("logradouro");
           String bairro = album.getString("bairro");
           String cidade = album.getString("cidade");
           String estado = album.getString("uf");   
           
        return null;
          
    }
}
