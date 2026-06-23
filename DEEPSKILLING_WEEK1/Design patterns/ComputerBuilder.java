public class ComputerBuilder {
    private final String cpu; private final int ram; private final int storage; private final boolean gpu;

    private ComputerBuilder(Builder b) { cpu=b.cpu; ram=b.ram; storage=b.storage; gpu=b.gpu; }

    public static class Builder {
        private String cpu; private int ram; private int storage; private boolean gpu;
        public Builder cpu(String v){cpu=v;return this;} public Builder ram(int v){ram=v;return this;}
        public Builder storage(int v){storage=v;return this;} public Builder gpu(boolean v){gpu=v;return this;}
        public ComputerBuilder build(){ return new ComputerBuilder(this); }
    }

    public String toString(){ return String.format("CPU=%s RAM=%d Storage=%d GPU=%b", cpu, ram, storage, gpu); }

    public static void main(String[] args){
        ComputerBuilder pc = new ComputerBuilder.Builder()
            .cpu("Intel i7").ram(16).storage(512).gpu(true).build();
        System.out.println(pc);
    }
}
