package com.handson.model.serializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.handson.model.Musica;

public class MusicasListSerializer extends StdSerializer<List<Musica>> {

	private static final long serialVersionUID = 1L;

	public MusicasListSerializer() {
		this(null);
	}

	public MusicasListSerializer(Class<List<Musica>> t) {
		super(t);
	}

	@Override
	public void serialize(List<Musica> items, JsonGenerator generator, SerializerProvider provider)
			throws IOException {

		List<String> ids = new ArrayList<>();
		for (Musica item : items) {
			ids.add(item.getNome());
		}
		generator.writeObject(ids);
	}

}
