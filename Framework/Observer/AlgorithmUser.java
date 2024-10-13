package Framework.Observer;

public class AlgorithmUser implements Observer {
    private String status;

    @Override
    public void atualizar(String status) {
        this.status = status;
        System.out.println("Status: " + status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
