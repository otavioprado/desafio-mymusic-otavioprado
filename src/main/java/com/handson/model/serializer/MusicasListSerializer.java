package com.handson.model.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.handson.model.Musicas;

public class MusicasListSerializer extends StdSerializer<List<Musicas>> {

	private static final long serialVersionUID = 1L;

	public MusicasListSerializer() {
		this(null);
	}

	public MusicasListSerializer(Class<List<Musicas>> t) {
		super(t);
	}

	@Override
	public void serialize(List<Musicas> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException {

		List<String> ids = new ArrayList<>();
		for (Musicas item : items) {
			ids.add(item.getNome());
		}
		generator.writeObject(ids);
	}

}
