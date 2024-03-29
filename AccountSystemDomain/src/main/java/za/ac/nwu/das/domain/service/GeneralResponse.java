package za.ac.nwu.das.domain.service;

import java.io.Serializable;
import java.util.Objects;

public class GeneralResponse<T> implements Serializable
{
    private static final long serialVersionUID = 5181719437031172578L;

    private final boolean successful;
    private final transient T payload;

    public GeneralResponse(boolean successful, T payload){
        this.successful = successful;
        this.payload = payload;
    }

    public boolean isSuccessful(){
        return successful;
    }

    public T getPayload(){
        return payload;
    }

    @Override
    public boolean equals(Object obj){

        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;

        GeneralResponse<?> that = (GeneralResponse<?>) obj;

        return successful == that.successful && Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode(){

        return Objects.hash(successful, payload);
    }

    @Override
    public String toString(){

        return "GeneralResponse{" + "payload" + payload +
                                "successful" + successful + '}';
    }


}
