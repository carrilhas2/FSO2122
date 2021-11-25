import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class CanalComunicacao {

	private static RandomAccessFile memoryMappedFile;
	private static MappedByteBuffer map;
	private static File file;
	private static FileChannel canal;
	
	private final static int MAX_BUFFER = 8448;//256bytes texto + 4bytes id + 4Bytes tipo * 32 mensagens 
	private static int idx = 0;
	private int idxPut , idxGet = 0;
	private static final int delta = 264;

	public CanalComunicacao() {
		memoryMappedFile = null;
		map = null;
		canal = null;
		file = null;
		//file.deleteOnExit();
	}
	
	public void abrirCanal(String nomeFicheiro) {
		try {
			file = new File(nomeFicheiro);
			memoryMappedFile = new RandomAccessFile(file, "rw");
			canal = memoryMappedFile.getChannel();
			map = canal.map(FileChannel.MapMode.READ_WRITE, 0, MAX_BUFFER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Mensagem getAndSet(Mensagem msg) {
		try {
			FileLock fl = canal.lock();
			if(msg.getTipo() == EnumEstados.LER_MENSAGEM.getEstado()) {
				Mensagem msgParaLer = get();
				fl.release();
				return msgParaLer;
			} else {
				put(msg);
				fl.release();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Mensagem get() {
		map.position(idxGet);
		
		Integer id = map.getInt();
		Integer tipo = map.getInt();
		String texto = "";
		for(int i = 0; i<256; i++) {
			texto += map.getChar();
		}

		if(id != null && tipo != 0) {
			Mensagem msg = new Mensagem(tipo,texto);
			msg.setId(id);
			idx = id+1;
			System.out.println(msg.toString());
			idxGet += delta;
			if(idxGet == MAX_BUFFER) {
				idxGet = 0;
			}
			return msg;
		}
		
		return new Mensagem(EnumEstados.ESPERAR_MENSAGEM.getEstado(), "m="+id);
	}

	private void put(Mensagem msg) {
		map.position(idxPut);
		map.putInt(idx);
		map.putInt(msg.getTipo());
		for( char c : transformaTexto(msg.getTexto())) {
			map.putChar(c);
		};
		idxPut += delta;
		if(idxPut == MAX_BUFFER) {
			idxPut = 0;
		}
	}

	public void fecharCanal() {
		try {
			CanalComunicacao.memoryMappedFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private char[] transformaTexto(String texto) {
		char[] resultado = new char[256];

		for (int i = 0; i < 256; i++) {
			resultado[i] = (texto.toCharArray().length>i)?texto.toCharArray()[i]:' ';
		}
		System.out.println(String.valueOf(resultado));
		return resultado;
	}

}
