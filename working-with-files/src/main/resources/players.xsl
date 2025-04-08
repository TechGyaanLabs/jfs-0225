<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <!-- Root template -->
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm">
                    <fo:region-body margin="1cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="24pt" font-weight="bold" margin-bottom="20pt">List of Books</fo:block>
                    <fo:block font-size="18pt" margin-bottom="12pt">Player Details:</fo:block>

                    <!-- Loop through each book and format its details -->
                    <fo:table margin-bottom="8pt" margin-top="8pt">
                        <fo:table-column column-width="proportional-column-width(1)"/>
                        <fo:table-column column-width="proportional-column-width(1)"/>
                        <fo:table-column column-width="proportional-column-width(1)"/>
                        <fo:table-header>
                            <fo:table-row>
                                <fo:table-cell font-weight="bold">
                                    <fo:block>Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell font-weight="bold">
                                    <fo:block>Team</fo:block>
                                </fo:table-cell>
                                <fo:table-cell font-weight="bold">
                                    <fo:block>Role</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:for-each select="players/player">
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block><xsl:value-of select="name"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block><xsl:value-of select="team"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block><xsl:value-of select="role"/></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>