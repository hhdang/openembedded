DESCRIPTION = "Gtk+ WebCore - JavaScriptCore"
HOMEPAGE = "http://gtk-webcore.sourceforge.net/"
LICENSE = "GPL"
PRIORITY = "optional"
SECTION = "gpe"

FIXEDSRCDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"
PV = "0.5.0+cvs${FIXEDSRCDATE}"
PR = "r1"

SRC_URI = "cvs://anonymous@gtk-webcore.cvs.sourceforge.net/cvsroot/gtk-webcore;module=JavaScriptCore;date=${FIXEDSRCDATE} \
           file://libm.patch"
S = "${WORKDIR}/JavaScriptCore"

inherit autotools pkgconfig

# zap CPPFLAGS to avoid trouble with internal vs. pcre from staging
CPPFLAGS = ""

do_configure () {
	autotools_do_configure
	cd ${S}

	# prevent libtool from linking libs against libstdc++, libgcc, ...
	cat ${HOST_SYS}-libtool | sed -e 's/postdeps=".*"/postdeps=""/' > ${HOST_SYS}-libtool.tmp
	mv ${HOST_SYS}-libtool.tmp ${HOST_SYS}-libtool
}

do_stage () {
	oe_libinstall -so -C kjs libjscore ${STAGING_LIBDIR}

	autotools_stage_includes

	install -d ${STAGING_INCDIR}/osb/JavaScriptCore
	for i in ${S}/kjs/*.h ${S}/kjs/new; do
		install -m 0644 $i ${STAGING_INCDIR}/osb/JavaScriptCore
	done
}
