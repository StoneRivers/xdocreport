/**
 * Copyright (C) 2011 Angelo Zerr <angelo.zerr@gmail.com> and Pascal Leclercq <pascal.leclercq@gmail.com>
 *
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fr.opensagres.xdocreport.template.formatter;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Collection;

/**
 * Fields metadata serializer used to load {@link FieldsMetadata} from XML and
 * serialize {@link FieldsMetadata} to XML.
 * 
 */
public class FieldsMetadataXMLSerializer {

	private static final String FIELDS_START_ELT = "<fields>";
	private static final String FIELDS_END_ELT = "</fields>";

	private static final String LF = "\n";
	private static final String TAB = "\t";

	private static final FieldsMetadataXMLSerializer INSTANCE = new FieldsMetadataXMLSerializer();

	public static FieldsMetadataXMLSerializer getInstance() {
		return INSTANCE;
	}

	protected FieldsMetadataXMLSerializer() {

	}

	/**
	 * Load fields metadata in the given {@link FieldsMetadata} from the given
	 * XML reader.
	 * 
	 * Here a sample of XML reader :
	 * 
	 * <pre>
	 * <fields>
	 * 	<field name="project.Name" imageName="" listType="false" />
	 * 	<field name="developers.Name" imageName="" listType="true" />
	 * <field name="project.Logo" imageName="Logo" listType="false" />
	 * </fields>
	 * </pre>
	 * 
	 * @param fieldsMetadata
	 * @param reader
	 */
	public void load(FieldsMetadata fieldsMetadata, Reader reader) {
		// TODO, implement SAX Parser to load fields and call
		// fieldsMetadata.addField(fieldMetadata);
	}

	/**
	 * 
	 * Serialize as XML the given {@link FieldsMetadata} to the given XML
	 * writer.
	 * 
	 * Here a sample of XML writer :
	 * 
	 * <pre>
	 * <fields>
	 * 	<field name="project.Name" imageName="" listType="false" />
	 * 	<field name="developers.Name" imageName="" listType="true" />
	 * <field name="project.Logo" imageName="Logo" listType="false" />
	 * </fields>
	 * </pre>
	 * 
	 * @param fieldsMetadata
	 * @param writer
	 * @param indent
	 *            true if indent must be managed and false otherwise.
	 * @throws IOException
	 */
	public void save(FieldsMetadata fieldsMetadata, Writer writer,
			boolean indent) throws IOException {
		Collection<FieldMetadata> fields = fieldsMetadata.getFields();
		writer.write(FIELDS_START_ELT);
		for (FieldMetadata field : fields) {
			save(field, writer, indent);
		}
		writer.write(FIELDS_END_ELT);
	}

	private void save(FieldMetadata field, Writer writer, boolean indent)
			throws IOException {
		if (indent) {
			writer.write(LF);
			writer.write(TAB);
		}
		// TODO : generate
		// <field name="" imageName="" listType="true" >

	}
}
