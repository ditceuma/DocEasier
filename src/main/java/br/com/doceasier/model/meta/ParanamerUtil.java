package br.com.doceasier.model.meta;

import com.thoughtworks.paranamer.AnnotationParanamer;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import com.thoughtworks.paranamer.CachingParanamer;
import com.thoughtworks.paranamer.Paranamer;

class ParanamerUtil {

	protected static Paranamer getParanamer(){
		return new CachingParanamer(new AnnotationParanamer(new BytecodeReadingParanamer()));
	}
}
